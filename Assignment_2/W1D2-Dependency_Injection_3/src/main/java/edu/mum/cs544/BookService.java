package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookService implements IBookService {

	@Autowired
	public List<IBookSupplier> suppliers = new ArrayList<IBookSupplier>();

//	public BookService(IBookSupplier amazon,IBookSupplier barnesandnoble,IBookSupplier ebooks) {
//		suppliers.add(amazon);
//		suppliers.add(barnesandnoble);
//		suppliers.add(ebooks);
//	}

//	public BookService() {
//
//	}

	public void buy(Book book) {
		double lowestPrice = 0;
		IBookSupplier cheapestSupplier = null;
		// find the cheapest supplier
		for (IBookSupplier supplier : suppliers) {
			double price = supplier.computePrice(book.getIsbn());
			if (cheapestSupplier == null) {
				cheapestSupplier = supplier;
				lowestPrice = price;
			} else {
				if (price < lowestPrice) {
					cheapestSupplier = supplier;
					lowestPrice = price;
				}
			}
		}
		// buy with the cheapest supplier
		if (cheapestSupplier != null) {
			cheapestSupplier.order(book);
		}

	}
}