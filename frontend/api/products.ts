import { BaseApi } from '@/api/base'

export class ProductsAPI extends BaseApi {
    getProducts(params: any): Promise<any> {
        return this.get('/products', { params })
    }

    getProduct(id: any): Promise<any> {
        return this.get(`/products/${id}`)
    }

    createProduct(data: any): Promise<any> {
        return this.post('/products', data)
    }

    deleteProduct(id: any): Promise<any> {
        return this.delete(`/products/${id}`)
    }

    getChartPriceByTime(id: any, params: any): Promise<any> {
        return this.get(`/products/${id}/chartPriceByTime`, { params })
    }
}
