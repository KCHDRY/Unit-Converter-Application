// Generated by Dagger (https://dagger.dev).
package com.barryzea.simpleadmob.model;

import com.barryzea.simpleadmob.common.database.HistoryDAO;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class RepositoryImpl_Factory implements Factory<RepositoryImpl> {
  private final Provider<HistoryDAO> dbProvider;

  public RepositoryImpl_Factory(Provider<HistoryDAO> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public RepositoryImpl get() {
    return newInstance(dbProvider.get());
  }

  public static RepositoryImpl_Factory create(Provider<HistoryDAO> dbProvider) {
    return new RepositoryImpl_Factory(dbProvider);
  }

  public static RepositoryImpl newInstance(HistoryDAO db) {
    return new RepositoryImpl(db);
  }
}