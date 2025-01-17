// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.communication.ui.error

import com.azure.android.communication.ui.configuration.events.CommunicationUIErrorCode

internal class CallCompositeError(
    var communicationUIErrorCode: CommunicationUIErrorCode,
    var cause: Throwable,
)
