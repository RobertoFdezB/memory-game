package com.prueba.aplicacion.test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.aplicacion.domain.entity.Partida;
import com.prueba.aplicacion.mapper.PartidaMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class PartidaMapperTest {
	
    @Autowired
    private PartidaMapper partidaMapper;

    @Test
    public void testFindById() throws Exception {
    	Partida partida1 = partidaMapper.findById(1L);
    	Assert.assertNotNull(partida1);
    }
    
    @Test
    public void testGetAll() throws Exception {
    	List<Partida> partidas = partidaMapper.getAll();
    	Assert.assertEquals(12, partidas.size());
    }
    
    @Test
    public void testInsert() throws Exception {
    	partidaMapper.insert(new Partida(Date.valueOf("2021-12-31"),7,Time.valueOf("00:08:12")));
    	partidaMapper.insert(new Partida(Date.valueOf("2021-12-31"),10,Time.valueOf("00:15:14")));

        Assert.assertEquals(14, partidaMapper.getAll().size());
    }

    @Test
    public void testUpdate() throws Exception {
    	Partida partida1 = partidaMapper.findById(1L);
    	partida1.setFecha(Date.valueOf("2021-10-31"));
    	partida1.setMovimientos(12);
    	partida1.setTiempo(Time.valueOf("00:10:12"));
    	partidaMapper.update(partida1);
    	
    	Partida partida1Update = partidaMapper.findById(1L);
        Assert.assertTrue(Date.valueOf("2021-10-31").equals(partida1Update.getFecha()));
        Assert.assertTrue(12 == partida1Update.getMovimientos());
        Assert.assertTrue(Time.valueOf("00:10:12").equals(partida1Update.getTiempo()));
    }

    @Test
    public void testDelete() throws Exception {
    	Partida partida1 = partidaMapper.findById(1L);
    	
    	partidaMapper.delete(partida1);
    	
    	Partida partida1Borrado = partidaMapper.findById(1L);
    	
    	 Assert.assertNull(partida1Borrado);
    }
    
    @Test
    public void testDeleteById() throws Exception {
    	partidaMapper.deleteById(2L);
    	
    	Partida partida2Borrado = partidaMapper.findById(2L);
    	
    	Assert.assertNull(partida2Borrado);
    }
    
    @Test
    public void testDeleteAll() throws Exception {
    	partidaMapper.deleteAll();
    	Assert.assertNull(partidaMapper.getAll());
    }
}