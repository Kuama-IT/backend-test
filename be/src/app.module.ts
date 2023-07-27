import { Module } from '@nestjs/common';
import { KnexModule } from 'nest-knexjs';
import { DrinksModule } from './drinks/drinks.module';
import { DrinksDockerModule } from './drinks-docker/drinksDocker.module';

@Module({
  imports: [
    KnexModule.forRoot({
      config: {
        client: 'pg',
        useNullAsDefault: true,
        connection: {
          host: process.env.DRINKS_PG_CONTAINER_NAME,
          port: process.env.DRINKS_POSTGRES_PORT as unknown as number,
          password: process.env.DRINKS_POSTGRES_PASSWORD,
          user: process.env.DRINKS_POSTGRES_USER,
          database: process.env.DRINKS_POSTGRES_DB,
        },
      },
    }),
    DrinksModule,
    DrinksDockerModule,
  ],
  providers: [],
})
export class AppModule {}
