package data.repository

import data.model.Article
import network.api.NewsAPI

class NewsRepository {

    fun getAll(
        date: String,
        type: String,
        sortBy: String,
        apiKey: String,
        closure: (List<Article>) -> Unit
    ) {
        val newsApi = NewsAPI()
        newsApi.getAll(date, type, sortBy, apiKey)
        {
            it?.let {
                closure(it)
            }
        }
    }

}