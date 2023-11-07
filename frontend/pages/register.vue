<script setup lang="ts">
import { ref } from 'vue'

const page = ref({ title: 'Register' })
const breadcrumbs = ref([
  {
    text: 'Dashboard',
    disabled: false,
    href: '#',
  },
])

const showPassword = ref(false)
const accept = ref(false)
const tab = ref('one')
</script>

<template>
  <v-row>
    <v-col cols="12" md="4">
      <h2 class="tw-mb-2">Sign In</h2>
      <v-card class="tw-mb-2 tw-p-2 tw-text-[14px] tw-rounded-none" variant="tonal">
        <div>You can use these credentials for demo testing:</div>
        <div class="tw-flex">
          <div class="tw-w-1/2">
            <div class="tw-font-bold">Dealer:</div>
            <div>Dealer:</div>
            <div>Dealer:</div>
          </div>
          <div>
            <div class="tw-font-bold">User:</div>
            <div>Demo</div>
            <div>Demo</div>
          </div>
        </div>
      </v-card>
      <v-card class="tw-text-white tw-mb-2 tw-rounded-none tw-py-4 tw-px-2" color="#153e4d">
        <v-card-text class="tw-text-[15px] tw-font-bold pb-0">
          <div class="tw-mb-[14px]">Login or E-mail</div>
          <v-text-field class="tw-mb-1" density="compact" required type="email" variant="solo" />
          <div class="tw-mb-[14px]">Password</div>
          <v-text-field density="compact" required type="password" variant="solo" />
          <v-row class="tw-text-[13px]" dense>
            <v-col cols="7">
              <v-checkbox class="tw-ml-[-10px] tw-text-[13px]" dense hide-details label="Remember me" :ripple="false" />
            </v-col>
            <v-col class="tw-flex tw-items-center" cols="5">
              <v-btn class="tw-text-[13px]" variant="text">Forgot password</v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-btn class="tw-px-4 tw-text-[12px]" color="#1bc744" variant="flat">LOGIN</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="12" md="8">
      <v-tabs v-model="tab" color="primary" hide-slider>
        <v-tab>
          <h2 class="tw-mb-2">Sign Up</h2>
        </v-tab>
        <v-tab>
          <h2 class="tw-mb-2">Service</h2>
        </v-tab>
      </v-tabs>
      <v-window v-model="tab">
        <v-window-item value="one">
          <div class="tw-h-[5px] tw-bg-[#153e4d]" />
          <v-card class="tw-mb-2 tw-rounded-none tw-py-4 tw-px-2">
            <v-card-text class="tw-text-[15px] tw-font-bold pb-0">
              <v-row dense>
                <v-col class="sm:tw-pr-3" cols="12" sm="6">
                  <h4 class="tw-mb-[14px]">First Name</h4>
                  <v-text-field
                    class="tw-mb-1"
                    density="compact"
                    hide-details
                    placeholder="Enter First Name"
                    required
                    variant="outlined"
                  />
                </v-col>
                <v-col cols="12" sm="6">
                  <h4 class="tw-mb-[14px]">Last Name</h4>
                  <v-text-field
                    class="tw-mb-1"
                    density="compact"
                    hide-details
                    placeholder="Enter Last Name"
                    required
                    variant="outlined"
                  />
                </v-col>
                <v-col class="sm:tw-pr-3" cols="12" sm="6">
                  <h4 class="tw-mb-[14px]">Phone Number</h4>
                  <v-text-field
                    density="compact"
                    hide-details
                    placeholder="Enter Phone Number"
                    required
                    variant="outlined"
                  />
                  <v-checkbox class="tw-relative tw-left-[-12px]" color="#1bc744" hide-details>
                    <template #label>
                      <span class="tw-text-[11px]">I have a WhatsApp account with this number</span>
                    </template>
                  </v-checkbox>
                </v-col>
                <v-col cols="12" sm="6">
                  <h4 class="tw-mb-[14px]">Email*</h4>
                  <v-text-field
                    class="tw-mb-1"
                    density="compact"
                    hide-details
                    placeholder="Enter Email"
                    required
                    variant="outlined"
                  />
                </v-col>
                <v-col class="sm:tw-pr-3" cols="12" sm="6">
                  <h4 class="tw-mb-[14px]">Login*</h4>
                  <v-text-field density="compact" hide-details placeholder="Enter Login" required variant="outlined" />
                  <v-checkbox v-model="accept" class="tw-relative tw-left-[-12px]" color="#1bc744" hide-details>
                    <template #label>
                      <span class="tw-text-[11px]">I accept the term of the service</span>
                    </template>
                  </v-checkbox>
                </v-col>
                <v-col ccols="12" sm="6">
                  <h4 class="tw-mb-[14px]">Password*</h4>
                  <v-text-field
                    :append-inner-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                    class="tw-mb-1"
                    density="compact"
                    hide-details
                    placeholder="Enter Password"
                    required
                    :type="showPassword ? 'text' : 'password'"
                    variant="outlined"
                    @click:append-inner="showPassword = !showPassword"
                  />
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-actions>
              <v-btn class="tw-px-2 tw-text-[12px] tw-text-white" color="#1bc744" :disabled="!accept" variant="flat">
                SIGN UP NOW!
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-window-item>
        <v-window-item value="two">
          <div class="tw-h-[5px] tw-bg-[#153e4d]" />
          <div class="text-center">EMPTY</div>
        </v-window-item>
      </v-window>
    </v-col>
  </v-row>
</template>
<style lang="scss">
.tw-rounded-none {
  border-radius: 0 !important;
}
</style>
