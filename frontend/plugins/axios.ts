import axios from 'axios'
import { stringify } from 'qs'

export default defineNuxtPlugin(() => {
  const runtimeConfig = useRuntimeConfig()
  const baseUrl = runtimeConfig.public.apiBase

  const client = axios.create({
    baseURL: baseUrl,
    timeout: 10000, // 10s
    // withCredentials: true,
  })

  client.interceptors.request.use((config) => {
    config.paramsSerializer = (params) => stringify(params, { encode: false, arrayFormat: 'comma' })

    return config
  })

  client.interceptors.response.use(
    (response) => {
      return response
    },
    (error) => {
    }
  )

  return {
    provide: {
      axios: client,
    },
  }
})
