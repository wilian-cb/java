/*
 ************************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */

package br.com.uol.pagseguro.example;

import java.util.Iterator;

import br.com.uol.pagseguro.domain.Error;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.enums.NotificationType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.NotificationService;

public class ReceiveNotifications {

    public static void main(String[] args) {

        // Substitute the code below with a notification code for your
        // transaction.

        String notificationCode = "ADB456F3BB3EBB3E6ADAA4919F80EEB1118F";
        String notificationType = "transaction";

        Transaction transaction = null;

        try {

            if (notificationType == NotificationType.TRANSACTION.getValue()) {
                transaction = NotificationService.checkTransaction(PagSeguroConfig.getAccountCredentials(),
                        notificationCode);
            }

        } catch (PagSeguroServiceException e) {

            Iterator<Error> itr = e.getErrors().iterator();

            while (itr.hasNext()) {
                Error error = (Error) itr.next();
                System.out.println("[Código do erro] " + error.getCode());
                System.out.println("[Mensagem de erro] " + error.getMessage());
            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

        if (transaction != null) {
            System.out.println("ID da transação: " + transaction.getCode());
            System.out.println("Status da transação: " + transaction.getStatus().getTypeFromValue());
        }

    }

    private ReceiveNotifications() {
    }
}