package br.panaggio.movilenext_aula2_kotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.panaggio.movilenext_aula2_kotlin.R
import br.panaggio.movilenext_aula2_kotlin.adapter.ProgrammingLanguageAdapter
import br.panaggio.movilenext_aula2_kotlin.adapter.RepositoryAdapter
import br.panaggio.movilenext_aula2_kotlin.model.ProgrammingLanguage
import br.panaggio.movilenext_aula2_kotlin.network.GitHubReposResult
import br.panaggio.movilenext_aula2_kotlin.network.Repository
import br.panaggio.movilenext_aula2_kotlin.network.RepositoryRetriever
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GitHubReposResult> {
        override fun onFailure(call: Call<GitHubReposResult>?, t: Throwable?) {
            toast("Fail loading repos")
        }

        override fun onResponse(call: Call<GitHubReposResult>?, response: Response<GitHubReposResult>?) {
            toast("Load finished")

            response?.isSuccessful.let {
                response?.body()?.repos.let {
                    setupRepoRecyclerView(it ?: emptyList())
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDefaultRecyclerView()

        btReload.setOnClickListener {
            setupDefaultRecyclerView()
        }
    }

    private fun setupDefaultRecyclerView() {
        val items = fetchProgrammingLanguagesItems()

        val programmingLanguageAdapter = ProgrammingLanguageAdapter(items) {
            longToast("Loading ${it.name} repositories")
            repositoryRetriever.getLanguagesRepositories(callback, it.name ?: "")
        }
        recyclerView.adapter = programmingLanguageAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupRepoRecyclerView(listItems: List<Repository>) {

        val repositoryAdapter = RepositoryAdapter(listItems) { longToast("Clicked item ${it.name}") }
        recyclerView.adapter = repositoryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchProgrammingLanguagesItems(): List<ProgrammingLanguage> {
        return listOf(
                ProgrammingLanguage("Kotlin", 2016, "Kotlin Description", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name2", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name3", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name4", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name1", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name2", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name3", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp),
                ProgrammingLanguage("name4", 2018, "blablabla", R.drawable.ic_developer_board_black_24dp)
        )
    }
}
