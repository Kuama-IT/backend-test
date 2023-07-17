import { logger } from '@utils/logger';
import { Routes } from '@interfaces/routes.interface';
import paginationMiddleware from '@middlewares/pagination.middleware';
import errorMiddleware from '@middlewares/error.middleware';
import express from 'express';

class App {
    public app: express.Application;
    public port: string | number;

    constructor(routes: Routes[]) {
        this.app = express();
        this.port = 3000;

        this.initializeMiddlewares();
        this.initializeRoutes(routes);
        this.initializeErrorHandling();
    }

    public listen() {
        this.app.listen(this.port, () => {
            logger.info(`===================================`);
            logger.info(`🚀 App listening on the port ${this.port}`);
            logger.info(`===================================`);
        });
    }

    public getServer() {
        return this.app;
    }

    private initializeMiddlewares() {
        this.app.use(paginationMiddleware);
    }

    private initializeRoutes(routes: Routes[]) {
        // Setup all unauth routes
        logger.info(`===================================`);
        routes.forEach(route => {
            if (!route.auth) {
                logger.info(`Unauth route ${route.path} up and running`);
                this.app.use('/api/', route.router);
            }
        });
        logger.info(`===================================`);

        // This setup is not needed, but I wanted to show how I usually do routes initialization,
        // because in node you cannot mix auth and unauth routes during starting setup.
        // If you do a mix, you risk sticking authentication to the first one that really need
        // the autentication and all subsequent routes will be authenticated even if it was not intended.

        // Setup all auth routes
        // routes.forEach(route => {
        //     if (route.auth) {
        //         logger.info(`Auth route ${route.path} up and running`);
        //         this.app.use(auth.verifyMiddleware);                         // in this case middleware is needed
        //         this.app.use('/api/', route.router);
        //     }
        // });
        // logger.info(`=================================`);
    }

    private initializeErrorHandling() {
        this.app.use(errorMiddleware);
    }
}

export default App;
