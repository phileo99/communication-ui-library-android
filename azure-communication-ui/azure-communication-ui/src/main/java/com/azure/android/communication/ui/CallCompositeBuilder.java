// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.communication.ui;

import com.azure.android.communication.ui.configuration.ThemeConfiguration;
import com.azure.android.communication.ui.configuration.CallCompositeConfiguration;

/**
 * Builder for creating {@link CallComposite}.
 */
public final class CallCompositeBuilder {

    private ThemeConfiguration themeConfig = null;

    /**
     * Sets an optional theme for call-composite to use by {@link CallComposite}.
     *
     * @param theme {@link ThemeConfiguration}.
     * @return {@link CallCompositeBuilder}
     */
    public CallCompositeBuilder theme(final ThemeConfiguration theme) {
        this.themeConfig = theme;
        return this;
    }

    /**
     * Creates {@link CallComposite}.
     *
     * @return {@link CallComposite}
     */
    public CallComposite build() {
        final CallCompositeConfiguration config = new CallCompositeConfiguration();
        config.setThemeConfig(themeConfig);

        return new CallComposite(config);
    }
}