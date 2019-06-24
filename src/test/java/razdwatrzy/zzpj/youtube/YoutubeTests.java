package razdwatrzy.zzpj.youtube;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YoutubeTests {
    @Test
    public void testApi(){
        YouTubeService service = new YouTubeService();
        int views = service.getViewsCountForVideo("AIzaSyDRmYcV4AhmuIHPI_c0b3ESokONHj1c4O0");
//        assertEquals(287028, views);

    }

}
