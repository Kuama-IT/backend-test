import axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios';
import dotenv from 'dotenv';
dotenv.config();

const axiosClient: AxiosInstance = axios.create({
    timeout: 10000,
    baseURL: process.env.COCKTAIL_BASE_URL,
});

const httpClient = {
    async get<T>(url: string, config?: AxiosRequestConfig): Promise<AxiosResponse<T>> {
        return await axiosClient.get<T>(url, config);
    },
};

export default httpClient;
