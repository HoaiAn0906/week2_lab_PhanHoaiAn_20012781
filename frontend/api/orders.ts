import { BaseApi } from '@/api/base'

export class OrdersAPI extends BaseApi {
    createOrder(data: any): Promise<any> {
        return this.post('/orders', data)
    }
}