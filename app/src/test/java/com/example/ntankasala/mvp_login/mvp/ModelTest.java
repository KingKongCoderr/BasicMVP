package com.example.ntankasala.mvp_login.mvp;

import android.Manifest;
import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.mockito.verification.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;


/**
 * Created by ntankasala on 8/8/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ModelTest {


    Model model;
    @Mock
    GetPreferenceContract.View view;

    @Mock
    GetPreferenceCallBack getPreferenceCallBack;

    @Mock
    Presenter presenter;

    Context context;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        context = RuntimeEnvironment.application;
        model = new Model(context);
    }


    @Test
    public void Should_ReturnDefaultMessage_For_WrongResourceId() {
        //given
        String resource_id = anyString();

        //when
        model.getPreference(resource_id, getPreferenceCallBack);

        //then
        /**
         * This kind of testing is sometimes called behavior testing.
         * Behavior testing does not check the result of a method call, but it checks that a method is called with the right parameters.
         */
        Mockito.verify(getPreferenceCallBack, times(1)).onReceiveFailure("not found");
        Mockito.verify(getPreferenceCallBack).onReceiveFailure(anyString());

    }


    @Test
    public void Should_ReturnCorrectResource_For_CorrectResourceId()  {

        //given
        String resource_id = "sharedpreferences";

        //when
        model.getPreference(resource_id, getPreferenceCallBack);

        //then
        Mockito.verify(getPreferenceCallBack, times(1)).onReceiveSuccess("Inside Model");
        Mockito.verify(getPreferenceCallBack).onReceiveSuccess(anyString());

    }
}