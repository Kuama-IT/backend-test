import * as https from 'https';

const baseUrlApi='https://www.thecocktaildb.com/api/json/v1/1/';

export class HttpsHandler {

    constructor() {
        this.https = https;
    }

    getRequest(url){
        return new Promise((resolve, reject) => {
            this.https.get(baseUrlApi+url, res => {
                let data = [];
    
                res.on('data', chunk => {
                    data.push(chunk);
                });
    
                res.on('end', () => {                    
                    const parsedData = data.length==0 ? {} : JSON.parse(Buffer.concat(data).toString());
                    resolve(parsedData);
                });
            }).on('error', err => {
                console.log('Error: ', err.message);
                reject(err.message);
            });
        });    
    }
}
