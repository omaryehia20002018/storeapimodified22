package com.example.servicestoreproject.mapper;

import com.example.servicestoreproject.dto.StockHistoryDto;
import com.example.servicestoreproject.entity.StockHistory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T19:24:25+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class StockHistoryMapperImpl implements StockHistoryMapper {

    @Override
    public StockHistoryDto toStockHistoryDto(StockHistory stockHistory) {
        if ( stockHistory == null ) {
            return null;
        }

        StockHistoryDto stockHistoryDto = new StockHistoryDto();

        stockHistoryDto.setProductId( (long) stockHistory.getProductId() );
        stockHistoryDto.setStockhistoryid( stockHistory.getStockhistoryid() );
        stockHistoryDto.setType( stockHistory.getType() );
        stockHistoryDto.setQuantityChange( stockHistory.getQuantityChange() );
        stockHistoryDto.setTimeStamp( stockHistory.getTimeStamp() );

        return stockHistoryDto;
    }

    @Override
    public StockHistory toStockHistory(StockHistoryDto StockHistoryDto) {
        if ( StockHistoryDto == null ) {
            return null;
        }

        StockHistory stockHistory = new StockHistory();

        stockHistory.setStockhistoryid( StockHistoryDto.getStockhistoryid() );
        stockHistory.setType( StockHistoryDto.getType() );
        stockHistory.setQuantityChange( StockHistoryDto.getQuantityChange() );
        stockHistory.setTimeStamp( StockHistoryDto.getTimeStamp() );
        if ( StockHistoryDto.getProductId() != null ) {
            stockHistory.setProductId( StockHistoryDto.getProductId().intValue() );
        }

        return stockHistory;
    }
}
