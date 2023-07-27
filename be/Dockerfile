FROM node:19.4.0

WORKDIR /usr/src/app

COPY be/package*.json ./
COPY be/tsconfig*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 80
EXPOSE 8080
EXPOSE 3000
CMD ["node", "dist/main.js"]