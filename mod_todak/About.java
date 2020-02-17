/*
 * Copyright (C) 2016-2018 crDroid Android Project
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
 */
package com.crdroid.settings.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.SearchIndexableResource;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;

import com.crdroid.settings.R;

import java.util.List;
import java.util.ArrayList;

public class About extends SettingsPreferenceFragment implements Indexable {

    public static final String TAG = "About";

    private String KEY_CRDROID_SOURCE = "crdroid_source";
    private String KEY_CRDROID_TELEGRAM = "crdroid_telegram";
    private String KEY_CRDROID_SHARE = "crdroid_share";
    private String KEY_CRDROID_TRANSLATE = "crdroid_translate";
    private String KEY_CRDROID_WEBSITE = "crdroid_website";

    private Preference mSourceUrl;
    private Preference mTelegramUrl;
    private Preference mShare;
    private Preference mTranslate;
    private Preference mWebsite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.crdroid_settings_about);

        mSourceUrl = findPreference(KEY_CRDROID_SOURCE);
        mTelegramUrl = findPreference(KEY_CRDROID_TELEGRAM);
        mShare = findPreference(KEY_CRDROID_SHARE);
        mTranslate = findPreference(KEY_CRDROID_TRANSLATE);
        mWebsite = findPreference(KEY_CRDROID_WEBSITE);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference == mSourceUrl) {
            launchUrl("https://github.com/TodakROM");
        } else if (preference == mTelegramUrl) {
            launchUrl("https://todak.com");
        } else if (preference == mShare) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, String.format(
                    getActivity().getString(R.string.share_floko_message), Build.MODEL));
            startActivity(Intent.createChooser(intent, getActivity().getString(R.string.share_floko_chooser_title)));
        } else if (preference == mTranslate) {
            launchUrl("https://todak.com");
        } else if (preference == mWebsite) {
            launchUrl("https://todak.com");
        }

        return super.onPreferenceTreeClick(preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(intent);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CRDROID_SETTINGS;
    }

    /**
     * For search
     */
    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {
                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                        boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();
                    SearchIndexableResource sir = new SearchIndexableResource(context);
                    sir.xmlResId = R.xml.crdroid_settings_about;
                    result.add(sir);

                    return result;
                }
            };
}
