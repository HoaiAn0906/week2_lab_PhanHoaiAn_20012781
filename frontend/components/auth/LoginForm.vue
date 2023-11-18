<script setup lang="ts">
import { ref } from 'vue'
import { useToast } from 'vue-toastification'
import { useForm } from 'vee-validate'
import * as Yup from 'yup'
import { useI18n } from 'vue-i18n'
import TextInput from '@/components/forms/form-validation/TextInput.vue'

const router = useRouter()
const checkbox = ref(false)
const valid = ref(false)
const show1 = ref(false)
const { signIn, data } = useAuth()
const toast = useToast()
const { t } = useI18n()
const loading = ref(false)

const { values, handleSubmit } = useForm({
  validationSchema: Yup.object().shape({
    email: Yup.string().email().required(),
    password: Yup.string().min(6).required(),
  }),
  initialValues: {
    email: '',
    password: '',
  },
})

const login = () => {
  loading.value = true
  signIn('credentials', {
    email: values.email,
    password: values.password,
    redirect: false,
    callbackUrl: '/api/v1/auth/login',
  }).then(({ error, ok }) => {
    if (error) {
      toast.error(t('login.message.error'))
      loading.value = false
    } else {
      router.push({ path: '/' })
    }
  })
  console.log('auth')
}
</script>

<template>
  <v-row class="d-flex mb-3">
    <v-col class="pr-2" cols="6" sm="6">
      <v-btn block class="border text-subtitle-1" size="large" variant="outlined">
        <img alt="google" class="mr-2" height="16" src="/images/svgs/google-icon.svg" />
        <span class="d-sm-flex d-none mr-1">Sign in with</span>
        Google
      </v-btn>
    </v-col>
    <v-col class="pl-2" cols="6" sm="6">
      <v-btn block class="border text-subtitle-1" size="large" variant="outlined">
        <img alt="facebook" class="mr-1" height="25" src="/images/svgs/facebook-icon.svg" width="25" />
        <span class="d-sm-flex d-none mr-1">Sign in with</span>
        FB
      </v-btn>
    </v-col>
  </v-row>
  <div class="d-flex align-center text-center mb-6">
    <div class="text-h6 w-100 px-5 font-weight-regular auth-divider position-relative">
      <span class="bg-surface px-5 py-3 position-relative">or sign in with</span>
    </div>
  </div>
  <v-form v-slot="{ errors, isSubmitting }" class="mt-5" @submit="login">
    <v-label class="text-subtitle-1 font-weight-medium pb-2 text-lightText">Username</v-label>
    <text-input name="email" success-message="Got it, we won't spam you!" type="email" />
    <v-label class="text-subtitle-1 font-weight-medium pb-2 text-lightText">Password</v-label>
    <text-input name="password" success-message="Nice and secure!" type="password" />
    <div class="d-flex flex-wrap align-center my-3 ml-n2">
      <v-checkbox
        v-model="checkbox"
        color="primary"
        hide-details
        required
        :rules="[(v:any) => !!v || 'You must agree to continue!']"
      >
        <template #label>Remeber this Device</template>
      </v-checkbox>
      <div class="ml-sm-auto">
        <NuxtLink class="text-primary text-decoration-none text-body-1 opacity-1 font-weight-medium" to="">
          Forgot Password ?
        </NuxtLink>
      </div>
    </div>
    <v-btn block color="primary" :disabled="!values.password" flat :loading="loading" size="large" type="submit">
      Sign In
    </v-btn>
    <div v-if="errors.apiError" class="mt-2">
      <v-alert color="error">{{ errors.apiError }}</v-alert>
    </div>
  </v-form>
</template>
