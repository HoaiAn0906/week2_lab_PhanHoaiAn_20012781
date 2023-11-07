<script setup lang="ts">
import { ref } from 'vue'
import {useCustomizerStore} from "@/stores/customizer";
import {useCartStore} from "@/stores/carts";

const customizer = useCustomizerStore()
const priority = ref(customizer.setHorizontalLayout ? 0 : 0)
const bg = ref('#3c6176')

const cartStore = useCartStore()

//use getters do get data from store
const cartItems = computed(() => cartStore.getCart)

</script>

<template>
  <v-app-bar
    :color="bg"
    elevation="0"
    height="92"
    :priority="priority"
    scroll-behavior="fade-image inverted"
    scroll-threshold="100"
  >
    <div :class="customizer.boxed ? 'maxWidth v-toolbar__content px-lg-0 px-0' : 'v-toolbar__content px-6'">
      <div class="d-sm-flex d-none">
        <LcFullLogo />
      </div>

      <v-spacer />

      <div class="ml-3 mr-sm-0">
        <v-menu
          :close-on-content-click="false"
          content-class="menu-account-header"
          max-width="250"
          open-delay="100"
          open-on-hover
          transition="slide-x-transition"
        >
          <template #activator="{ props }">
            <v-btn class="btn-account tw-bg-white tw-mr-8" icon size="28" v-bind="props">
              <v-icon color="#5b6771" size="18">mdi-account</v-icon>
            </v-btn>
          </template>

          <v-card class="tw-ml-[-108px] tw-mt-2 card-account-header">
            <v-container>
              <v-row class="tw-text-base" :dense="true">
                <v-col cols="12">
                  <span class="tw-font-bold">Login or E-mail</span>
                  <v-text-field
                    class="tw-mt-1"
                    color="#5b6771"
                    dense
                    hide-details
                    outlined
                    placeholder="Enter your login or e-mail"
                    type="text"
                  />
                </v-col>
                <v-col cols="12">
                  <span class="tw-font-bold">Password</span>
                  <v-text-field
                    class="tw-mt-1"
                    color="#5b6771"
                    dense
                    hide-details
                    outlined
                    placeholder="Enter password"
                    type="text"
                  />
                </v-col>
                <v-col cols="12">
                  <v-checkbox class="tw-ml-[-10px]" dense hide-details label="Remember me" :ripple="false" />
                </v-col>
                <v-col cols="12">
                  <div class="d-flex align-center">
                    <v-btn class="tw-uppercase" color="#1bc744" height="44" outlined>
                      <span class="tw-text-white tw-font-bold">Login</span>
                    </v-btn>

                    <div class="tw-text-center tw-mx-auto">
                      <a class="tw-cursor-pointer tw-no-underline" href="/register">
                        <span class="tw-text-gray-500">Sign up</span>
                      </a>
                    </div>
                  </div>
                </v-col>
              </v-row>
            </v-container>
          </v-card>
        </v-menu>

        <v-btn class="tw-uppercase" color="primary" height="44" variant="flat" :to="{ name: 'carts' }">
          <v-icon color="white" size="24">mdi-cart-arrow-down</v-icon>
          <span class="tw-text-white tw-font-bold tw-ml-1">{{ cartItems.length }}</span>
        </v-btn>
      </div>
    </div>
  </v-app-bar>
</template>

<style lang="scss">
.btn-account {
  transition: all 0.3s ease-in-out;
}
.btn-account:hover {
  background-color: rgb(27, 199, 68) !important;
}
.menu-account-header {
  margin-top: 40px;
  contain: initial;
}
.menu-account-header::before {
  position: absolute;
  content: '';
  top: 20px;
  right: 226px;
  transform: translateY(-100%);
  width: 10px;
  height: 13px;
  border-left: 10px solid transparent;
  border-right: 10px solid transparent;
  border-bottom: 13px solid #fff;
}
.card-account-header {
  box-shadow: none !important;
}
</style>
