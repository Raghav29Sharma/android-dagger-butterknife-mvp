/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.presenter;

import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment;
import com.vestrel00.daggerbutterknifemvp.ui.common.presenter.BasePresenter;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildView;
import com.vestrel00.daggerbutterknifemvp.util.PerActivityUtil;
import com.vestrel00.daggerbutterknifemvp.util.PerChildFragmentUtil;
import com.vestrel00.daggerbutterknifemvp.util.PerFragmentUtil;
import com.vestrel00.daggerbutterknifemvp.util.SingletonUtil;

import javax.inject.Inject;

/**
 * An implementation of {@link Example3ChildPresenter}.
 */
@PerChildFragment
final class Example3ChildPresenterImpl extends BasePresenter<Example3ChildView>
        implements Example3ChildPresenter {

    private final SingletonUtil singletonUtil;
    private final PerActivityUtil perActivityUtil;
    private final PerFragmentUtil perFragmentUtil;
    private final PerChildFragmentUtil perChildFragmentUtil;

    @Inject
    Example3ChildPresenterImpl(Example3ChildView view, SingletonUtil singletonUtil,
                               PerActivityUtil perActivityUtil, PerFragmentUtil perFragmentUtil,
                               PerChildFragmentUtil perChildFragmentUtil) {
        super(view);
        this.singletonUtil = singletonUtil;
        this.perActivityUtil = perActivityUtil;
        this.perFragmentUtil = perFragmentUtil;
        this.perChildFragmentUtil = perChildFragmentUtil;
    }

    @Override
    public void onDoSomething() {
        // Do something here. Maybe make an asynchronous call to fetch data...
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        something += "\n" + perChildFragmentUtil.doSomething();
        view.showSomething(something);
    }
}
