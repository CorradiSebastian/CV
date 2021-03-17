package com.scorradi.cv.views.main

<<<<<<< Updated upstream
import android.app.Activity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.scorradi.cv.R
=======
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.scorradi.cv.databinding.ActivityMainBinding
import com.scorradi.cv.views.components.ExperienceItemAdapter
import com.scorradi.cv.views.fragments.JobFragment
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
>>>>>>> Stashed changes

class MainActivity : Activity() {

    @BindView(R.id.viewPager)
    private lateinit var ViewPager: ViewPager

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< Updated upstream
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this);
=======
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvExperiences.layoutManager = linearLayoutManager

        presenter = MainPresenter(this)

        val personObservable = Observable.create<PersonModel>{
            emitter ->
            emitter.onNext(presenter.loadPersonModel())
            emitter.onComplete()
            //showPerson(personModel = presenter.loadPersonModel())
        }

        val personConsumer = object : Consumer<PersonModel> {
            override fun accept(personModel: PersonModel?) {
                showPerson(personModel!!)
            }
        }

        with(personObservable) {
            subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(personConsumer)
        }

        val experiencesObservable = Observable.create<List<ExperienceModel>>{
                emitter ->
            emitter.onNext(presenter.loadExperienceModels())
            emitter.onComplete()
            //showPerson(personModel = presenter.loadPersonModel())
        }
        val experiencesConsumer = object : Consumer<List<ExperienceModel>> {
            override fun accept(experiences: List<ExperienceModel>) {
                showExperiences(experiences)
            }
        }
        
        with(experiencesObservable) {
            subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(experiencesConsumer)
        }
/*
        disposable = personObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { showPerson(it) },
                { showError(it)},
                {} )
        */
        //presenter.onCreate();
    }

    fun showError(error: Throwable){

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    override fun showPerson(personModel: PersonModel) {
        binding.tvName.text = personModel.Name
        binding.tvDNI.text = personModel.Id
        binding.tvAge.text = Integer.toString(personModel.Age)
        binding.tvPhoneNumber.text = personModel.PhoneNumber
    }

    override fun showExperiences(experiences: List<ExperienceModel>) {
        val onClickListener = object : ExperienceItemAdapter.OnClickListener {
            override fun onClick(experienceModel: ExperienceModel) {
                presenter.onExperienceModelClick(experienceModel)
            }
        }

        val adapter = ExperienceItemAdapter(experiences, onClickListener)
        binding.rvExperiences.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun getContext(): Context {
        return this
    }
>>>>>>> Stashed changes

    }
}