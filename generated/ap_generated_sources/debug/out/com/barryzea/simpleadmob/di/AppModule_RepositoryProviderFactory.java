// Generated by Dagger (https://dagger.dev).
package com.barryzea.simpleadmob.di;

import com.barryzea.simpleadmob.common.database.HistoryDAO;
import com.barryzea.simpleadmob.model.Repository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_RepositoryProviderFactory implements Factory<Repository> {
  private final AppModule module;

  private final Provider<HistoryDAO> dbProvider;

  public AppModule_RepositoryProviderFactory(AppModule module, Provider<HistoryDAO> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public Repository get() {
    return repositoryProvider(module, dbProvider.get());
  }

  public static AppModule_RepositoryProviderFactory create(AppModule module,
      Provider<HistoryDAO> dbProvider) {
    return new AppModule_RepositoryProviderFactory(module, dbProvider);
  }

  public static Repository repositoryProvider(AppModule instance, HistoryDAO db) {
    return Preconditions.checkNotNullFromProvides(instance.repositoryProvider(db));
  }
}
