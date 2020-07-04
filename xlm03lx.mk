#
# Copyright (C) 2020 Fanthagiro Foe "guffoe"
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Bootanimation
PRODUCT_COPY_FILES += \
    vendor/xlm03lx/prebuilt/media/bootanimation/bootanimation.zip:system/media/bootanimation.zip

# Huawei stock system Media
PRODUCT_COPY_FILES += \
    vendor/xlm03lx/prebuilt/media/audio/alarms/Aegean_Sea.ogg:system/media/audio/alarms/Aegean_Sea.ogg \
    vendor/xlm03lx/prebuilt/media/audio/alarms/Alarm_Beep.ogg:system/media/audio/alarms/Alarm_Beep.ogg \
    vendor/xlm03lx/prebuilt/media/audio/notifications/Bongo.ogg:system/media/audio/notifications/Bongo.ogg \
    vendor/xlm03lx/prebuilt/media/audio/ringtones/Huawei_Tune_Living.ogg:system/media/audio/ringtones/Huawei_Tune_Living.ogg

# Packages
PRODUCT_PACKAGES += \
    FootejCamera \
    SimpleGallery \
    Phonograph

#Xperia Keyboard Metarial
PRODUCT_PACKAGES += \
    vendor/xlm03lx/xperiakyb/textinput-tng/XMFKB_6.apk:system/priv-app/textinput-tng/XMFKB_6.apk \
    vendor/xlm03lx/xperiakyb/textinput-tng/lib/arm64/libswiftkeysdk-java.so:system/priv-app/textinput-tng/lib/arm64/libswiftkeysdk-java.so

