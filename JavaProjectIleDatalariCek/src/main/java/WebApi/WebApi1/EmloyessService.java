package WebApi.WebApi1;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import WebApi.ProjeWebApi.Model.PersonelBilgi;

@Path(value = "liste")
public class EmloyessService {
	//static yapmamızın nedeni post ile data ekleme
 static	List<PersonelBilgi> liste;
	static {
		liste=new ArrayList<PersonelBilgi>();
		liste.add(new PersonelBilgi("sadas", "sdasd", "asdasd", "asdasd"));
		liste.add(new PersonelBilgi("aaaaa", "aaaaa", "aaaaaaa", "aaaaa"));
		liste.add(new PersonelBilgi("sssss", "sssss", "sssss", "sssss"));
		liste.add(new PersonelBilgi("dddddd", "dddddd", "dddddd", "ddddd"));
		liste.add(new PersonelBilgi("ffffff", "ffffff", "ffffff", "fffff"));
		liste.add(new PersonelBilgi("gggggg", "ggggggg", "ggggggg", "gggggg"));
		liste.add(new PersonelBilgi("hhhhhh", "hhhhhhh", "hhhhhhhh", "hhhhhhhh"));
	}
	
	public EmloyessService() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/p1")
	public List<PersonelBilgi> personelList(){
		
		return liste;
	}
	
	
	@POST
	@Path("/p1")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response dataEkle(PersonelBilgi ss) {
		if(!ss.equals(null)) {
		liste.add(ss);
		return Response.status(200).entity("eklendi").build();
		}
		else {
			return Response.status(406).entity("Bos datalar geldi").build();
		}
		
		
		
	}
	
	//data silmek delete
	@DELETE
	@Path("/del/{isim}")
	@Produces(MediaType.APPLICATION_XML) //silinen veriyi göstermek için
	public Response personelSil(@PathParam("isim")String isim) {
		for(int i=0;i<liste.size();i++) {
			if(liste.get(i).getAdi().equals(isim.toLowerCase())) {
				liste.remove(i);
				
				
			}
			else {
				return Response.status(404).entity("bulunamadi").build();
			}
		}
		return Response.status(200).entity(liste).build();
		
	}
	
	
	
	
	//PathParam
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xmlbirkisi/{id}")
	public PersonelBilgi kisi(@PathParam("id")String id) {		
		PersonelBilgi ss=liste.get(Integer.parseInt(id));
		
		return ss;
	}
	
	
	//iki tane parametre
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/xmlbirkisi/{id}/{isim}")
	public PersonelBilgi kisi(@PathParam("id")String id,@PathParam("isim")String isim) {		
		PersonelBilgi ss=liste.get(Integer.parseInt(id));
		if(ss.getAdi().equals(isim)) {
			return ss;
		}
		else {
			PersonelBilgi aa=liste.get(5);
			return aa;
		}
	}
	
	
	
	
	//parametreyi filtreledik regex karakterler ile
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/isimeGore/{isim:[a-z A-Z]+}")
	public Response pathParam(@PathParam("isim")String isim) {		
		for(PersonelBilgi gecici:liste) {
			if(gecici.getAdi().equals(isim)) {
				return Response.status(2000).entity(gecici).build();
			}
			
		}
		
		       return Response.status(300).entity("bulunamadi").build();
	}
	
	
	
	
	//QueryParam
	//http://localhost:8080/WebApi1/webapi/liste/tcno?soyad=sssss&tcno=hhhhhhhh
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tcno")
	public Response queryParam(@QueryParam("soyad")String soyad,@QueryParam("tcno")String tcno) {		
		for(PersonelBilgi gecici:liste) {
			if(gecici.getTcno().equals(tcno)) {
				return Response.status(2000).entity(gecici).build();
			}
			
		}
		
		       return Response.status(300).entity("bulunamadi").build();
	}
	
	
	
	
	
	//MatrixParam
	//http://localhost:8080/WebApi1/webapi/liste/adSoyadTc;ad=baran;soyad=beger;tcno=aaaaaaa;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adSoyadTc")
	public Response matrixParam(@MatrixParam("ad")String ad,@MatrixParam("soyad")String soyad,@MatrixParam("tcno")String tcno) {		
		for(PersonelBilgi gecici:liste) {
			if(gecici.getTcno().equals(tcno)) {
				return Response.status(2000).entity(gecici).build();
			}
			
		}
		
		       return Response.status(300).entity("bulunamadi").build();
	}
	
	
	
	
	
	//formParam
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adsoyad")
	public Response formParam(@FormParam("ad")String ad,@FormParam("soyad")String soyad) {		
		for(PersonelBilgi gecici:liste) {
			if(gecici.getAdi().equals(ad) && gecici.getSoyadi().equals(soyad)) {
				return Response.status(2000).entity(gecici).build();
			}
			
		}
		
		       return Response.status(300).entity("bulunamadi").build();
	}
	
	

}
