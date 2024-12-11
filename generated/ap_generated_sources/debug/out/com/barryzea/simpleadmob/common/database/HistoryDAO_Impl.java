package com.barryzea.simpleadmob.common.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.barryzea.simpleadmob.common.entities.HistoryEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryDAO_Impl implements HistoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryEntity> __insertionAdapterOfHistoryEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMeasure;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllHistory;

  public HistoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryEntity = new EntityInsertionAdapter<HistoryEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `HistoryEntity` (`id`,`fromUnitName`,`toUnitName`,`fromUnitValue`,`toUnitValue`,`timestamp`,`scientificNotation`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFromUnitName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFromUnitName());
        }
        if (value.getToUnitName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getToUnitName());
        }
        stmt.bindDouble(4, value.getFromUnitValue());
        stmt.bindDouble(5, value.getToUnitValue());
        stmt.bindLong(6, value.getTimestamp());
        stmt.bindDouble(7, value.getScientificNotation());
      }
    };
    this.__preparedStmtOfDeleteMeasure = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from HistoryEntity where id=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllHistory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from HistoryEntity";
        return _query;
      }
    };
  }

  @Override
  public long saveHistory(final HistoryEntity historyEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfHistoryEntity.insertAndReturnId(historyEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMeasure(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMeasure.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMeasure.release(_stmt);
    }
  }

  @Override
  public void deleteAllHistory() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllHistory.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllHistory.release(_stmt);
    }
  }

  @Override
  public List<HistoryEntity> getAllHistory() {
    final String _sql = "select * from HistoryEntity order by timestamp desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFromUnitName = CursorUtil.getColumnIndexOrThrow(_cursor, "fromUnitName");
      final int _cursorIndexOfToUnitName = CursorUtil.getColumnIndexOrThrow(_cursor, "toUnitName");
      final int _cursorIndexOfFromUnitValue = CursorUtil.getColumnIndexOrThrow(_cursor, "fromUnitValue");
      final int _cursorIndexOfToUnitValue = CursorUtil.getColumnIndexOrThrow(_cursor, "toUnitValue");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfScientificNotation = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificNotation");
      final List<HistoryEntity> _result = new ArrayList<HistoryEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HistoryEntity _item;
        _item = new HistoryEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpFromUnitName;
        if (_cursor.isNull(_cursorIndexOfFromUnitName)) {
          _tmpFromUnitName = null;
        } else {
          _tmpFromUnitName = _cursor.getString(_cursorIndexOfFromUnitName);
        }
        _item.setFromUnitName(_tmpFromUnitName);
        final String _tmpToUnitName;
        if (_cursor.isNull(_cursorIndexOfToUnitName)) {
          _tmpToUnitName = null;
        } else {
          _tmpToUnitName = _cursor.getString(_cursorIndexOfToUnitName);
        }
        _item.setToUnitName(_tmpToUnitName);
        final double _tmpFromUnitValue;
        _tmpFromUnitValue = _cursor.getDouble(_cursorIndexOfFromUnitValue);
        _item.setFromUnitValue(_tmpFromUnitValue);
        final double _tmpToUnitValue;
        _tmpToUnitValue = _cursor.getDouble(_cursorIndexOfToUnitValue);
        _item.setToUnitValue(_tmpToUnitValue);
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        _item.setTimestamp(_tmpTimestamp);
        final double _tmpScientificNotation;
        _tmpScientificNotation = _cursor.getDouble(_cursorIndexOfScientificNotation);
        _item.setScientificNotation(_tmpScientificNotation);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
