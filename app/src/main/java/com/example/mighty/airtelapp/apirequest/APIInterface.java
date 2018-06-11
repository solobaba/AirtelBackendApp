package com.example.mighty.airtelapp.apirequest;

import com.example.mighty.airtelapp.model.Feed;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    String BASE_URL = "http://phplaravel-116401-370897.cloudwaysapps.com/";

    @Headers("Content-Type: application/json")
    @GET("api/admin/data_request")
    Call<Feed> getData();

    @Headers("Content-Type: eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijk4YjNkM2RhZTg1YTk5MDM2YzVj" +
            "ZGRmMjBjMjgyYmUxMmI3ZTYyMTgzNzRiNDRlNzA1MTUzM2Y1YzA5NzI1ODZlZWYzYzJjNzZkYjhmM2YzIn0.eyJh" +
            "dWQiOiIxIiwianRpIjoiOThiM2QzZGFlODVhOTkwMzZjNWNkZGYyMGMyODJiZTEyYjdlNjIxODM3NGI0NGU3MDUx" +
            "NTMzZjVjMDk3MjU4NmVlZjNjMmM3NmRiOGYzZjMiLCJpYXQiOjE1Mjg3MTk0NzksIm5iZiI6MTUyODcxOTQ3OSwi" +
            "ZXhwIjoxNTYwMjU1NDc5LCJzdWIiOiIxMCIsInNjb3BlcyI6W119.GUY8Ta3PZUj5aWeyIaXJXN3ZzwYSmZ1vYTv" +
            "BlyJxAwyUPNixZ4Qcl-MoNo-3YONE7D9nrnswNsM0UU1Yw24v7lUC4Vc6Lo812TqPziTehw6bH76R2sF6rTkkZza" +
            "272nXEtTjnRl8acE6kM1W4Sf0jMKzYdel_3HqkPn4ueAam35lBOlTvHRWct5on9MR4XDXQJbmok56S91AuKDezOME" +
            "PrCNR32RbLAoU88mNx4T7D623jUlhstkJyzyBdppN96H1DJWYAI8MOTDlmnT_cn7dOVtCnUp9JT5Ol_CKNEZY8n1" +
            "PNiw0teS1GEPljM79jL6ffvveEi4KpWOc0H9QuC7YrsDTJM04Wa7jGERn0ucvlyG49EZtBBmhvDXBVP8ZICOGV" +
            "cji27e0_7KIOAhBf_pd1KoFTIMxDwaAh4HRBVFFPko58vYZGRBh4OyXfJJTv4JENy_FI2S4Xqsh1TAn6eOLEKLeBi" +
            "hdxprQzHF_WhCfz2v6xPZlGTo4Iy81eS3aEa4UuaTpM4wEWS_egvpQ6DXzafwUruq47FMbnK7JPrLk-KvgADFO_Djxd" +
            "f9c3uvSnVef3DH25r5_2zVgx6IECZVCSb0eooY-UpgIHuEHdTZ5oXWl_uyucdRlo4TCkLhtfAocaYsOFrX0WcxaXrRW1" +
            "hv6JAgb4EycScsIkL-YfMDWGw")
    @POST("api/admin/data_request")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);
}
