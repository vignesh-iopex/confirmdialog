/*
 * Copyright 2014 Vignesh Periasami
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.vignesh_iopex.confirmdialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.github.vignesh_iopex.confirmdialog.Confirm.getDialogRenderer;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AppDgFragment extends Fragment {
  private DialogRenderer dialogRenderer;

  @Override public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(dialogRenderer.getLayoutId(), container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    dialogRenderer.bindView(view);
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    dialogRenderer = getDialogRenderer(activity, getArguments(), this);
  }

  @Override public void onPause() {
    dialogRenderer.dismissDialog();
    super.onPause();
  }
}