import { AxiosInstance } from 'axios'
import {ProductsAPI} from "@/api/products";
import {OrdersAPI} from "@/api/orders";
import {OrderDetailsAPI} from "@/api/orderDetails";

export class Api<T extends unknown> {
  public readonly products: ProductsAPI
  public readonly orders: OrdersAPI
  public readonly orderDetails: OrderDetailsAPI

  constructor(axios: AxiosInstance) {
    this.products = new ProductsAPI(axios)
    this.orders = new OrdersAPI(axios)
    this.orderDetails = new OrderDetailsAPI(axios)
  }
}
