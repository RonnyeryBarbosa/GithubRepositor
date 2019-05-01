package com.ronnyerybarbosa.githubrepositor.ui.activity.list

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.R
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.ui.activity.profile.ProfileActivity
import com.ronnyerybarbosa.githubrepositor.ui.activity.show.ShowRepositoryActivity
import com.ronnyerybarbosa.githubrepositor.ui.adapters.RepositorItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_view_repository.*

class ListRepositoriesActivity : AppCompatActivity(), ListRepositoriesView, SearchView.OnQueryTextListener,RepositorItemAdapter.ItemClickListener {


    lateinit var listRepositoriesPresenterImpl: ListRepositoriesPresenter

    lateinit var adapter: RepositorItemAdapter


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_git)
        supportActionBar?.title = getString(R.string.app_name)

        listRepositoriesPresenterImpl = getPresenter()

        listRepositoriesPresenterImpl.loadData()

        searchView.setOnQueryTextListener(this)

    }

    fun getPresenter(): ListRepositoriesPresenter
    {
        return ListRepositoriesPresenterImpl( RetrofitBuilder().createService(ApiService::class.java),this)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        listRepositoriesPresenterImpl.unsubscribe()
        listRepositoriesPresenterImpl.onDestroy()
    }

    override fun onDataError(e: Throwable)
    {
        progressBar.visibility = View.GONE

        txt_error.visibility = View.VISIBLE

        txt_error.text = getString((R.string.error))
    }

    override fun onItemClicked(repository: Repository)
    {

        val intent = Intent(this, ShowRepositoryActivity::class.java)

        intent.putExtra(Repository.PARSE, repository)

        startActivity(intent)

    }

    override fun onQueryTextSubmit(query: String?): Boolean
    {
        adapter.filter.filter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean
    {
        adapter.filter.filter(newText)
        return false
    }

    override fun onDataStarted()
    {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDataCompleted()
    {
        progressBar.visibility = View.GONE

    }

    override fun onListRepositories(repositories: MutableList<Repository>)
    {
        list_repo.layoutManager = LinearLayoutManager(this)
        adapter = RepositorItemAdapter(repositories, this,this)
        list_repo.adapter =  adapter
    }

    /**
     * On Create Menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        //infla cutumizet menu
        menuInflater.inflate(R.menu.menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item!!.itemId == R.id.profile)
        {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
