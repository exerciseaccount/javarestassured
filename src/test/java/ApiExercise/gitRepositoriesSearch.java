package ApiExercise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import globalResources.po;


public class gitRepositoriesSearch {

    @Test
    public void apiRestRateLimitValidation() {
        RestAssured.baseURI = po.mainUrl;
        given().
        queryParam(po.commonParam, po.comomParamUserTagValue).
        queryParam(po.sortParam, po.sortValue).
        queryParam(po.orderParam, po.orderValueDesc).
        get(po.commonResource).
        then().assertThat().statusCode(200).
        and().contentType(ContentType.JSON).
        and().header(po.limitString, equalTo(po.ten)).
        and().header(po.remainingString, equalTo(po.nine)).
        and().header(po.serverIdentifier, po.serverName);
    }



    @Test
    public void defaultSearchResultsForTetrisSearch() {
        RestAssured.baseURI = po.mainUrl;
        Response res = given().
        given().
        queryParam(po.commonParam, po.comomParamUserTagValue).
        queryParam(po.sortParam, po.sortValue).
        queryParam(po.orderParam, po.orderValueAsc).
        get(po.commonResource).
        then().assertThat().statusCode(200).
        and().contentType(ContentType.JSON).
        and().header(po.limitString, equalTo(po.ten)).
        and().header(po.serverIdentifier, po.serverName).
        extract().response();
        JsonPath jsonResponse = po.rawToJson(res);
        String obtainedResult = jsonResponse.get(po.itemDescriptionZero);
        Assert.assertEquals(obtainedResult, po.tagAssert);
    }



    @Test
    public void paginationSearchResultsForTetrisWithA100Results() {
        RestAssured.baseURI = po.mainUrl;
        Response res = given().
        given().
        queryParam(po.commonParam, po.comomParamUserTagValue).
        queryParam(po.sortParam, po.sortValue).
        queryParam(po.orderParam, po.orderValueDesc).
        queryParam(po.pageParam, po.three).
        queryParam(po.perPageParam, po.hundred).
        get(po.commonResource).
        then().assertThat().statusCode(200).
        and().contentType(ContentType.JSON).
        and().header(po.limitString, equalTo(po.ten)).
        and().header(po.serverIdentifier, po.serverName).
        extract().response();
        JsonPath jsonResponse = po.rawToJson(res);
        int itemsResults = jsonResponse.get(po.itemsSize);
        assert itemsResults == po.hundred;
    }



    @Test
    public void SearchResultsForASpecificUser() {
        RestAssured.baseURI = po.mainUrl;
        Response res = given().
        given().
        queryParam(po.commonParam, po.comomParamUserNameValue).
        queryParam(po.typeParam, po.typeValue).
        get(po.commonResource).
        then().assertThat().statusCode(200).
        and().contentType(ContentType.JSON).
        and().header(po.limitString, equalTo(po.ten)).
        and().header(po.serverIdentifier, po.serverName).
        extract().response();
        JsonPath jsonResponse = po.rawToJson(res);
        int count = jsonResponse.get(po.itemsSize);
        for (int i = 0; i < count; i++) {
            String countPrint = jsonResponse.get(po.items + "[" + i + "]" + po.fullName);
            Assert.assertThat(countPrint.toLowerCase(), containsString(po.userAssert));
        }
    }



    @Test
    public void SearchResultsForASpecificUserWithASpecificLanguage() {
        RestAssured.baseURI = po.mainUrl;
        Response res = given().
        given().
        queryParam(po.sortParam, po.sortValue).
        queryParam(po.orderParam, po.orderValueDesc).
        queryParam(po.pageParam, po.one).
        queryParam(po.perPageParam, po.fifty).
        get(po.resourceLanguage).
        then().assertThat().statusCode(200).
        and().contentType(ContentType.JSON).
        and().header(po.limitString, equalTo(po.ten)).
        and().header(po.serverIdentifier, po.serverName).
        extract().response();
        JsonPath jsonResponse = po.rawToJson(res);
        int count = jsonResponse.get(po.itemsSize);
        for (int i = 0; i < count; i++) {
            String countPrint = jsonResponse.get(po.items + "[" + i + "]" + po.language);
            Assert.assertThat(countPrint.toLowerCase(), containsString(po.languageAssert));
        }
    }
}