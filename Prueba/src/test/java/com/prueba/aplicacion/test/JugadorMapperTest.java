package com.prueba.aplicacion.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.aplicacion.domain.entity.Jugador;
import com.prueba.aplicacion.mapper.JugadorMapper;
import com.prueba.aplicacion.vo.RankingVO;

@RunWith(SpringRunner.class)
@SpringBootTest
class JugadorMapperTest {
	
    @Autowired
    private JugadorMapper jugadorMapper;

    @Test
    public void testFindById() throws Exception {
    	Jugador jugador1 = jugadorMapper.findById(1L);
    	Assert.assertNotNull(jugador1);
    }
    
    @Test
    public void testGetAll() throws Exception {
    	List<Jugador> jugadores = jugadorMapper.getAll();
    	Assert.assertEquals(10, jugadores.size());
    }
    
    @Test
    public void testInsert() throws Exception {
    	jugadorMapper.insert(new Jugador("Pepe", "Azul"));
    	jugadorMapper.insert(new Jugador("Paco", "Rojo"));
    	jugadorMapper.insert(new Jugador("Javier", "Verde"));

        Assert.assertEquals(13, jugadorMapper.getAll().size());
    }

    @Test
    public void testUpdate() throws Exception {
    	Jugador jugador1 = jugadorMapper.findById(1L);
    	jugador1.setNombre("Felipe");
    	jugador1.setEquipo("Dorado");
    	jugadorMapper.update(jugador1);
    	
    	Jugador jugador1Update = jugadorMapper.findById(1L);
        Assert.assertTrue("Felipe".equals(jugador1Update.getNombre()));
        Assert.assertTrue("Dorado".equals(jugador1Update.getEquipo()));
    }

    @Test
    public void testDelete() throws Exception {
    	Jugador jugador1 = jugadorMapper.findById(1L);
    	
    	jugadorMapper.delete(jugador1);
    	
    	Jugador jugador1Borrado = jugadorMapper.findById(1L);
    	
    	 Assert.assertNull(jugador1Borrado);
    }
    
    @Test
    public void testDeleteById() throws Exception {
    	jugadorMapper.deleteById(2L);
    	
    	Jugador jugador2Borrado = jugadorMapper.findById(2L);
    	
    	Assert.assertNull(jugador2Borrado);
    }
    
    @Test
    public void testDeleteAll() throws Exception {
    	jugadorMapper.deleteAll();
    	Assert.assertNull(jugadorMapper.getAll());
    }

    @Test
    public void testObtenerRanking() throws Exception {
        List<RankingVO> ranking = jugadorMapper.obtenerRanking();
        Assert.assertEquals(10, ranking.size());
    }
}