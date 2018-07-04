package com.ncrash.code.swf;

import static org.junit.Assert.assertNotNull;

import com.flagstone.transform.Movie;
import com.flagstone.transform.MovieTag;
import java.io.File;
import org.junit.Test;

/**
 * @author daekwon.kang
 * @since 2010. 10. 5.
 * @see
 */
public class MovieHeaderTest {

  @Test
  public void testBasic() throws Exception {
    File resourceFile = new File(getClass().getResource("Anthology_300x250_swf.swf").getFile());
    assertNotNull(resourceFile);
    //		InputStream in = new FileInputStream(resourceFile);

    Movie movie = new Movie();
    movie.decodeFromFile(resourceFile);

    for (MovieTag movieTag : movie.getObjects()) {
      System.out.println(movieTag.toString());
    }
  }
}
