import { ApiProperty } from '@nestjs/swagger';
import { IsEmail, IsString } from 'class-validator';

export class DtoDrinksFilter {
  @ApiProperty()
  @IsString()
  filter: string;

  @ApiProperty()
  @IsString()
  @IsEmail()
  filterType: string;
}
