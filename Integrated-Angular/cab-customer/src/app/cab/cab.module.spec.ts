import { CabModule } from './cab.module';

describe('CabModule', () => {
  let cabModule: CabModule;

  beforeEach(() => {
    cabModule = new CabModule();
  });

  it('should create an instance', () => {
    expect(cabModule).toBeTruthy();
  });
});
