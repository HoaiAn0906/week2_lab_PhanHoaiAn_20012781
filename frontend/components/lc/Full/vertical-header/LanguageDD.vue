<script setup lang="ts">
import { ref } from 'vue'
import { languageDD } from '@/_mockApis/headerData'
import flag1 from '~/images/flag/icon-flag-en.svg'
import flag2 from '~/images/flag/icon-flag-ro.svg'
import flag3 from '~/images/flag/icon-flag-zh.svg'
import flag4 from '~/images/flag/icon-flag-fr.svg'
import flag5 from '~/images/flag/icon-flag-vn.png'
</script>
<template>
  <!-- ---------------------------------------------- -->
  <!-- language DD -->
  <!-- ---------------------------------------------- -->
  <v-menu :close-on-content-click="true" location="bottom">
    <template #activator="{ props }">
      <v-btn class="tw-ml-[-12px]" color="primary" icon variant="text" v-bind="props">
        <v-avatar size="22">
          <img v-if="$i18n.locale === 'en'" :alt="$i18n.locale" class="obj-cover" height="22" :src="flag1" width="22" />
          <img v-if="$i18n.locale === 'fr'" :alt="$i18n.locale" class="obj-cover" height="22" :src="flag4" width="22" />
          <img v-if="$i18n.locale === 'ro'" :alt="$i18n.locale" class="obj-cover" height="22" :src="flag2" width="22" />
          <img v-if="$i18n.locale === 'zh'" :alt="$i18n.locale" class="obj-cover" height="22" :src="flag3" width="22" />
          <img v-if="$i18n.locale === 'vn'" :alt="$i18n.locale" class="obj-cover" height="22" :src="flag5" width="22" />
        </v-avatar>
      </v-btn>
    </template>
    <v-sheet elevation="10" rounded="md" width="200">
      <v-list class="theme-list">
        <v-list-item
          v-for="(item, index) in languageDD"
          :key="index"
          :active="$i18n.locale == item.value"
          active-color="primary"
          class="d-flex align-center"
          @click="() => ($i18n.locale = item.value)"
        >
          <template #prepend>
            <v-avatar size="22">
              <img :alt="item.avatar" class="obj-cover" height="22" :src="item.avatar" width="22" />
            </v-avatar>
          </template>
          <v-list-item-title class="text-subtitle-1 font-weight-regular">
            {{ item.title }}
            <span class="text-disabled text-subtitle-1 pl-2">({{ item.subtext }})</span>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-sheet>
  </v-menu>
</template>
