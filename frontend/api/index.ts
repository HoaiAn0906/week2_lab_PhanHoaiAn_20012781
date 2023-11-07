import { AxiosInstance } from 'axios'
import {ProductsAPI} from "~/api/products";

export class Api<T extends unknown> {
  public readonly products: ProductsAPI

  constructor(axios: AxiosInstance) {
    this.products = new ProductsAPI(axios)
  }
}
