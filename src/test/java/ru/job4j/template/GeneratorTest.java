package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorTest {

    @Test
    @Ignore
    public void whenWorks() {
        Generator generator = new GeneratorFirst();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Aslan");
        map.put("subject", "you");
        String rsl = generator.produce(temp, map);
        assertThat(rsl, is("I am a Aslan, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenNoKey() {
        Generator generator = new GeneratorFirst();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Aslan");
        String rsl = generator.produce(temp, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenExtraKey() {
        Generator generator = new GeneratorFirst();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Aslan");
        map.put("surname", "Magamaev");
        String rsl = generator.produce(temp, map);
    }
}