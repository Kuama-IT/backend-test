import { Module } from '@nestjs/common';
import { DrinksDockerService } from './drinksDocker.service';
import { DrinksDockerController } from './drinksDocker.controller';

@Module({
  providers: [DrinksDockerService],
  controllers: [DrinksDockerController],
})
export class DrinksDockerModule {}
