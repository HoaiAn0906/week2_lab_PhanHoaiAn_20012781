<script setup lang="ts"></script>

<template>
  <v-system-bar class="tw-bg-[#153E4D] tw-text-white tw-text-[11px] tw-uppercase" height="38">
    <template #default>
      <v-container class="tw-flex tw-items-center pa-0" height="38">
        <LcFullVerticalHeaderLanguageDD />

        <v-spacer />

        <div class="tw-flex tw-items-center">
          <v-icon class="tw-mr-1" color="white tw-opacity-100" size="14">mdi-phone</v-icon>
          <span>Top Bar Phone</span>
        </div>

        <div class="tw-flex tw-items-center md:tw-ml-[10px] lg:tw-ml-[30px]">
          <v-icon class="tw-mr-1" color="white tw-opacity-100" size="14">mdi-map-marker-alert</v-icon>
          <span>Top Bar Address</span>
        </div>

        <div class="tw-flex tw-items-center md:tw-ml-[10px] lg:tw-ml-[30px]">
          <v-icon class="tw-mr-1" color="white tw-opacity-100" size="14">mdi-clock-time-five</v-icon>
          <span>Top Bar Working Hours Label</span>
        </div>

        <div class="tw-flex md:tw-ml-[10px] lg:tw-ml-[20px] justify-between">
          <span class="tw-mr-2">Dealer Profile</span>
          <v-divider class="tw-h-1 tw-mt-[6px]" :vertical="true" />
          <span class="tw-ml-2">Dealer Profile</span>
        </div>

        <v-icon class="tw-mr-2 md:tw-ml-[10px] lg:tw-ml-[20px] tw-opacity-100" color="white" size="14">
          mdi-facebook
        </v-icon>

        <v-icon class="tw-mr-2 tw-opacity-100" color="white" size="14">mdi-twitter</v-icon>

        <v-icon class="tw-mr-2 tw-opacity-100" color="white" size="14">mdi-instagram</v-icon>

        <v-icon class="tw-mr-2 tw-opacity-100" color="white" size="14">mdi-linkedin</v-icon>

        <v-icon class="tw-opacity-100" color="white" size="14">mdi-google</v-icon>
      </v-container>
    </template>
  </v-system-bar>
</template>

<style scoped lang="scss"></style>
