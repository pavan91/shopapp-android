package com.client.shop.ui.blog.contract

import com.domain.entity.Article
import com.domain.interactor.blog.ArticleListUseCase
import com.ui.base.contract.BaseLcePresenter
import com.ui.base.contract.BaseLceView
import javax.inject.Inject

interface BlogView : BaseLceView<List<Article>>

class BlogPresenter @Inject constructor(private val articleListUseCase: ArticleListUseCase) :
        BaseLcePresenter<List<Article>, BlogView>(articleListUseCase) {

    fun loadArticles(perPage: Int, paginationValue: String? = null) {

        articleListUseCase.execute(
                { view?.showContent(it) },
                { resolveError(it) },
                ArticleListUseCase.Params(perPage, paginationValue)
        )
    }
}