import { logger } from '@utils/logger';
import App from '@/app';
import DrinkRoute from '@routes/drink.route';

const app = new App([new DrinkRoute()]);

app.listen();

process.on('unhandledRejection', (reason, p) => {
    logger.error('Unhandled Rejection at: Promise ' + p + ' reason: ' + reason);
});
