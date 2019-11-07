import { UserIdleModuleModule } from './user-idle-module.module';

describe('UserIdleModuleModule', () => {
  let userIdleModuleModule: UserIdleModuleModule;

  beforeEach(() => {
    userIdleModuleModule = new UserIdleModuleModule();
  });

  it('should create an instance', () => {
    expect(userIdleModuleModule).toBeTruthy();
  });
});
