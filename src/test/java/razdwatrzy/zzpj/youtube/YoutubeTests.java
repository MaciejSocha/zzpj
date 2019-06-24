package razdwatrzy.zzpj.youtube;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YoutubeTests {
    @Test
    public void testApi(){
        YouTubeService service = new YouTubeService();
        int views = service.getViewsCountForVideo("DQj3cOldMzM");
//        assertEquals(287028, views);

    }

}
