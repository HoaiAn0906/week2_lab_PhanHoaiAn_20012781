import axios, { AxiosError, AxiosInstance } from 'axios'
import { ToastInterface, useToast } from 'vue-toastification'
import { BaseResponse, ErrorResponse } from '@/types/ResponseTypes'

export class BaseApi {
  public readonly axios: AxiosInstance
  public readonly toast: ToastInterface

  constructor(axios: AxiosInstance) {
    this.axios = axios
    this.toast = useToast()
  }

  public async get(endpoint: string, config?: any): Promise<any> {
    try {
      console.log(endpoint, config)
      return (await this.axios.get(endpoint, config)).data
    } catch (error) {
      await this.toastError(error)
    }
  }

  public async post(endpoint: string, data?: any): Promise<any> {
    try {
      return (await this.axios.post(endpoint, data)).data
    } catch (error) {
      await this.toastError(error)
    }
  }

  public async put(endpoint: string, data?: any): Promise<any> {
    try {
      return (await this.axios.put(endpoint, data)).data
    } catch (error) {
      await this.toastError(error)
    }
  }

  public async delete(endpoint: string, data?: any): Promise<any> {
    try {
      return (await this.axios.delete(endpoint, data)).data
    } catch (error) {
      await this.toastError(error)
    }
  }

  private toastError(error: any) {
    return new Promise((resolve, reject) => {
      if (axios.isAxiosError(error)) {
        const axiosError = error as AxiosError<BaseResponse<ErrorResponse>>

        if (axiosError.response?.data.error) {
          this.toast.error(axiosError.response.data.error.message)

          if (axiosError.response.data.error.fields) {
            throw axiosError.response.data.error.fields
          }
        }

        if (axiosError.response?.status === 403) {
          // go back
        }
      }

      reject(error)
    })
  }
}
