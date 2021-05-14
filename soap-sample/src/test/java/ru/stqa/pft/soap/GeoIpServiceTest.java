package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {

  @Test
  public void testMyIp(){
    String ipLocation = new GeoIPService().getGeoIPServiceSoap().getIpLocation("194.28.29.152");
    assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>47</State></GeoIP>");
  }
}