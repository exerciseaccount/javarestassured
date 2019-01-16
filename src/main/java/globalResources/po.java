package globalResources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class po {
    public static final int one = 1;
    public static final int three = 3;
    public static final int fifty = 50;
    public static final int hundred = 100;
    public static final String ten = "10";
    public static final String nine = "9";
    public static final String mainUrl = "https://api.github.com";
    public static final String commonResource = "/search/repositories";
    public static final String commonParam = "q";
    public static final String comomParamUserNameValue = "dino";
    public static final String comomParamUserTagValue = "tetris";
    public static final String typeParam = "type";
    public static final String typeValue = "full_name";
    public static final String sortParam = "sort";
    public static final String sortValue = "stars";
    public static final String orderParam = "order";
    public static final String orderValueDesc = "desc";
    public static final String orderValueAsc = "asc";
    public static final String pageParam = "page";
    public static final String perPageParam= "per_page";
    public static final String limitString = "X-RateLimit-Limit";
    public static final String remainingString = "X-RateLimit-Remaining";
    public static final String serverIdentifier = "server";
    public static final String serverName = "GitHub.com";
    public static final String items = "items";
    public static final String fullName = ".full_name";
    public static final String itemsSize = "items.size()";
    public static final String itemDescriptionZero= "items[0].description";
    public static final String language = ".language";
    public static final String resourceLanguage = "/search/repositories?q=tetris+language:assembly";
    public static final String languageAssert = "assembly";
    public static final String userAssert = "dino";
    public static final String tagAssert = "tetris clone for educational purposes";


    public static JsonPath rawToJson(Response r) {
        String respon = r.asString();
        JsonPath x = new JsonPath(respon);
        return x;
    }
}
