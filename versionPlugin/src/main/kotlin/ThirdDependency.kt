object ThirdVersions {
    val retrofit = "2.9.0"
    val moshi="1.11.0"
    val timber = "4.7.1"
}

object Retrofit {
    val runtime = "com.squareup.retrofit2:retrofit:${ThirdVersions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${ThirdVersions.retrofit}"
    val mock = "com.squareup.retrofit2:retrofit-mock:${ThirdVersions.retrofit}"
    val scalars = "com.squareup.retrofit2:converter-scalars:${ThirdVersions.retrofit}"
    val moshi = "com.squareup.retrofit2:converter-moshi:${ThirdVersions.retrofit}"
    val moshiKts = "com.squareup.moshi:moshi-kotlin:${ThirdVersions.moshi}"
    val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${ThirdVersions.moshi}"
}

object Depend {
    val timber = "com.jakewharton.timber:timber:${ThirdVersions.timber}"
}
