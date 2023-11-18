import { BaseApi } from '@/api/base'

export class OrderDetailsAPI extends BaseApi {
    createOrderDetail(data: any): Promise<any> {
        return this.post('/order_details', data)
    }
}