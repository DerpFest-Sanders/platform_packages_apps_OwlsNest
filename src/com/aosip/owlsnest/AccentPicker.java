/*
 * Copyright (C) 2018 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aosip.owlsnest;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.om.IOverlayManager;
import android.os.Bundle;
import android.os.ServiceManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.statusbar.ThemeAccentUtils;

import com.android.settings.R;
import com.android.settings.core.instrumentation.InstrumentedDialogFragment;

public class AccentPicker extends InstrumentedDialogFragment implements OnClickListener {

    private static final String TAG_ACCENT_PICKER = "accent_picker";

    private View mView;

    private IOverlayManager mOverlayManager;
    private int mCurrentUserId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOverlayManager = IOverlayManager.Stub.asInterface(
                ServiceManager.getService(Context.OVERLAY_SERVICE));
        mCurrentUserId = ActivityManager.getCurrentUser();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mView = LayoutInflater.from(getActivity()).inflate(R.layout.accent_picker, null);

        if (mView != null) {
            initView();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mView)
                .setNegativeButton(R.string.cancel, this)
                .setNeutralButton(R.string.theme_accent_picker_default, this)
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    private void initView() {

        Button redAccent = mView.findViewById(R.id.redAccent);
        setAccent("1", redAccent);

        Button pinkAccent = mView.findViewById(R.id.pinkAccent);
        setAccent("2", pinkAccent);

        Button purpleAccent = mView.findViewById(R.id.purpleAccent);
        setAccent("3", purpleAccent);

        Button deeppurpleAccent = mView.findViewById(R.id.deeppurpleAccent);
        setAccent("4", deeppurpleAccent);

        Button indigoAccent = mView.findViewById(R.id.indigoAccent);
        setAccent("5", indigoAccent);

        Button blueAccent = mView.findViewById(R.id.blueAccent);
        setAccent("6", blueAccent);

        Button lightblueAccent = mView.findViewById(R.id.lightblueAccent);
        setAccent("7", lightblueAccent);

        Button cyanAccent = mView.findViewById(R.id.cyanAccent);
        setAccent("8", cyanAccent);

        Button tealAccent = mView.findViewById(R.id.tealAccent);
        setAccent("9", tealAccent);

        Button greenAccent = mView.findViewById(R.id.greenAccent);
        setAccent("10", greenAccent);

        Button lightgreenAccent = mView.findViewById(R.id.lightgreenAccent);
        setAccent("11", lightgreenAccent);

        Button limeAccent = mView.findViewById(R.id.limeAccent);
        setAccent("12", limeAccent);

        Button yellowAccent = mView.findViewById(R.id.yellowAccent);
        setAccent("13", yellowAccent);

        Button amberAccent = mView.findViewById(R.id.amberAccent);
        setAccent("14", amberAccent);

        Button orangeAccent = mView.findViewById(R.id.orangeAccent);
        setAccent("15", orangeAccent);

        Button deeporangeAccent = mView.findViewById(R.id.deeporangeAccent);
        setAccent("16", deeporangeAccent);

        Button brownAccent = mView.findViewById(R.id.brownAccent);
        setAccent("17", brownAccent);

        Button greyAccent = mView.findViewById(R.id.greyAccent);
        setAccent("18", greyAccent);

        Button bluegreyAccent = mView.findViewById(R.id.bluegreyAccent);
        setAccent("19", bluegreyAccent);

        Button blackAccent = mView.findViewById(R.id.blackAccent);
        // Change the accent picker button depending on whether or not the dark theme is applied
        blackAccent.setBackgroundColor(getResources().getColor(
                ThemeAccentUtils.isUsingDarkTheme(mOverlayManager, mCurrentUserId) ? R.color.accent_picker_white_accent : R.color.accent_picker_dark_accent));
        blackAccent.setBackgroundTintList(getResources().getColorStateList(
                ThemeAccentUtils.isUsingDarkTheme(mOverlayManager, mCurrentUserId) ? R.color.accent_picker_white_accent : R.color.accent_picker_dark_accent));
        setAccent("20", blackAccent);

        Button qAccentOne = mView.findViewById(R.id.qAccentOne);
        setAccent("22", qAccentOne);

        Button qAccentTwo = mView.findViewById(R.id.qAccentTwo);
        setAccent("23", qAccentTwo);

        Button qAccentThree = mView.findViewById(R.id.qAccentThree);
        setAccent("24", qAccentThree);

        Button qAccentFour = mView.findViewById(R.id.qAccentFour);
        setAccent("25", qAccentFour);

        Button qAccentFive = mView.findViewById(R.id.qAccentFive);
        setAccent("26", qAccentFive);

        Button qAccentSix = mView.findViewById(R.id.qAccentSix);
        setAccent("27", qAccentSix);

        Button brandAccentOne = mView.findViewById(R.id.brandAccentOne);
        setAccent("28", brandAccentOne);

        Button brandAccentTwo = mView.findViewById(R.id.brandAccentTwo);
        setAccent("29", brandAccentTwo);

        Button brandAccentThree = mView.findViewById(R.id.brandAccentThree);
        setAccent("30", brandAccentThree);

        Button brandAccentFour = mView.findViewById(R.id.brandAccentFour);
        setAccent("31", brandAccentFour);

        Button brandAccentFive = mView.findViewById(R.id.brandAccentFive);
        setAccent("32", brandAccentFive);

        Button brandAccentSix = mView.findViewById(R.id.brandAccentSix);
        setAccent("33", brandAccentSix);

        Button brandAccentSeven = mView.findViewById(R.id.brandAccentSeven);
        setAccent("34", brandAccentSeven);

        Button brandAccentEight = mView.findViewById(R.id.brandAccentEight);
        setAccent("35", brandAccentEight);

        Button brandAccentNine = mView.findViewById(R.id.brandAccentNine);
        setAccent("36", brandAccentNine);

        Button brandAccentTen = mView.findViewById(R.id.brandAccentTen);
        setAccent("37", brandAccentTen);

        Button brandAccentEleven = mView.findViewById(R.id.brandAccentEleven);
        setAccent("38", brandAccentEleven);

        Button brandAccentTwelve = mView.findViewById(R.id.brandAccentTwelve);
        setAccent("39", brandAccentTwelve);

        Button brandAccentThirteen = mView.findViewById(R.id.brandAccentThirteen);
        setAccent("40", brandAccentThirteen);

        Button brandAccentFourteen = mView.findViewById(R.id.brandAccentFourteen);
        setAccent("41", brandAccentFourteen);

        Button brandAccentFifteen = mView.findViewById(R.id.brandAccentFifteen);
        setAccent("42", brandAccentFifteen);

        Button brandAccentSixteen = mView.findViewById(R.id.brandAccentSixteen);
        setAccent("43", brandAccentSixteen);

        Button brandAccentSeventeen = mView.findViewById(R.id.brandAccentSeventeen);
        setAccent("44", brandAccentSeventeen);

        Button brandAccentEighteen = mView.findViewById(R.id.brandAccentEighteen);
        setAccent("45", brandAccentEighteen);

        Button brandAccentNineteen = mView.findViewById(R.id.brandAccentNineteen);
        setAccent("46", brandAccentNineteen);

        Button brandAccentTwenty = mView.findViewById(R.id.brandAccentTwenty);
        setAccent("47", brandAccentTwenty);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        ContentResolver resolver = getActivity().getContentResolver();

        if (which == AlertDialog.BUTTON_NEGATIVE) {
            dismiss();
        }
        if (which == AlertDialog.BUTTON_NEUTRAL) {
            Settings.System.putIntForUser(resolver,
                    Settings.System.ACCENT_PICKER, 0, mCurrentUserId);
            dismiss();
        }
    }

    public static void show(Fragment parent) {
        if (!parent.isAdded()) return;

        final AccentPicker dialog = new AccentPicker();
        dialog.setTargetFragment(parent, 0);
        dialog.show(parent.getFragmentManager(), TAG_ACCENT_PICKER);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.OWLSNEST;
    }

    private void setAccent(final String accent, final Button buttonAccent) {
        final ContentResolver resolver = getActivity().getContentResolver();
        if (buttonAccent != null) {
            buttonAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, Integer.parseInt(accent), mCurrentUserId);
                    dismiss();
                }
            });
        }
    }
}
